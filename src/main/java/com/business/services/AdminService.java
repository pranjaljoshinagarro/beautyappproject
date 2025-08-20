package com.business.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.business.entities.Admin;
import com.business.repositories.AdminRepository;

@Component
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // Get all Admins
    @Cacheable(value = "admins")
    public List<Admin> getAll() {
        return (List<Admin>) this.adminRepository.findAll();
    }

    // Get Single Admin
    @Cacheable(value = "admin", key = "#id")
    public Admin getAdmin(int id) {
        return this.adminRepository.findById(id).orElse(null);
    }

    // ✅ Update Admin (preserve password if not sent)
    @CachePut(value = "admin", key = "#id")
    @CacheEvict(value = "admins", allEntries = true) // refresh admin list
    public void updateAdmin(Admin admin, int id) {
        Optional<Admin> optional = this.adminRepository.findById(id);

        if (optional.isPresent()) {
            Admin existingAdmin = optional.get();

            // Keep the same ID
            admin.setAdminId(id);

            // Preserve password if not provided
            if (admin.getAdminPassword() == null || admin.getAdminPassword().isEmpty()) {
                admin.setAdminPassword(existingAdmin.getAdminPassword());
            }

            this.adminRepository.save(admin);
        } else {
            System.out.println("⚠ Admin with ID " + id + " not found. Update skipped.");
        }
    }

    // Delete Admin
    @CacheEvict(value = { "admin", "admins" }, allEntries = true)
    public void delete(int id) {
        this.adminRepository.deleteById(id);
    }

    // Add Admin
    @CacheEvict(value = "admins", allEntries = true)
    public void addAdmin(Admin admin) {
        this.adminRepository.save(admin);
    }

    // Validate login credentials (no caching for security reasons)
    public boolean validateAdminCredentials(String email, String password) {
        Admin admin = adminRepository.findByadminEmail(email);
        return admin != null && admin.getAdminPassword().equals(password);
    }
}

