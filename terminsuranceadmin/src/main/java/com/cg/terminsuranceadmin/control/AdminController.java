package com.cg.terminsuranceadmin.control;
import java.util.List;


//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.terminsuranceadmin.entity.Admin;
import com.cg.terminsuranceadmin.exception.ResourceNotFoundException;
import com.cg.terminsuranceadmin.service.AdminService;
@CrossOrigin 
@RestController
@RequestMapping("/api/v2")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@GetMapping("/admins")
	public List<Admin> getAllAdmins() {
		return adminService.getAllAdmins();
	}

	@GetMapping("/admin/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable(value = "id") Integer adminId) throws ResourceNotFoundException {
		Admin admin= adminService.findAdminById(adminId);
		return  ResponseEntity.ok(admin);
	}
	@PostMapping("/admin")
	public Admin createAdmin( @RequestBody Admin admin ) {
		return adminService.saveAdmin(admin);
	}

	@PutMapping("/admin/{id}")
	public ResponseEntity<Admin> updateAdminById(@PathVariable(value = "id") Integer adminId,
			 @RequestBody Admin admin) throws ResourceNotFoundException {
		Admin admin1= adminService.updateAdmin(adminId, admin);
		return  ResponseEntity.ok(admin1);
	}

	 @DeleteMapping("/admin/{id}")
	 public ResponseEntity<Boolean> deleteAdmin(@PathVariable(value = "id") Integer adminId,@RequestBody Admin admin) throws ResourceNotFoundException	{
			Boolean admin1 = adminService.deleteAdminById(adminId);
			return  ResponseEntity.ok(admin1);
    }

}
