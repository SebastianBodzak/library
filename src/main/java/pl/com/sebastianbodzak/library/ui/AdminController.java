package pl.com.sebastianbodzak.library.ui;

import org.springframework.web.bind.annotation.*;
import pl.com.sebastianbodzak.library.api.CreateEmployeeRequest;
import pl.com.sebastianbodzak.library.api.AdminPanel;
import pl.com.sebastianbodzak.library.api.CreateEmployeeResponse;

/**
 * Created by Dell on 2016-10-11.
 */
@RestController
@RequestMapping("/panel/{adminId}")
public class AdminController {

    private AdminPanel adminPanel;

    public AdminController(AdminPanel adminPanel) {
        this.adminPanel = adminPanel;
    }

    @PutMapping
    public CreateEmployeeResponse addEmployee(@PathVariable Long adminId, @RequestBody CreateEmployeeRequest employeeRequest) {
        return adminPanel.createEmployee(employeeRequest, adminId);
    }
}
