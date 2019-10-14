package ru.stacy.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.stacy.dto.CompanyDTO;
import ru.stacy.service.CompanyService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/companies")
    public ResponseEntity<List<CompanyDTO>> findAll() {
        return ResponseEntity.ok(companyService.findAll());
    }

    @GetMapping("/companies/{id}")
    public ResponseEntity<CompanyDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.findById(id));
    }

    @PostMapping("/companies")
    public ResponseEntity<Long> create(@RequestBody CompanyDTO companyDTO) {
        return ResponseEntity.ok(companyService.create(companyDTO));
    }

    @PutMapping("/companies/{id}")
    public ResponseEntity<Long> update(@PathVariable Long id, @RequestBody CompanyDTO updCompanyDTO) {
        return ResponseEntity.ok(companyService.updateById(id, updCompanyDTO));
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.deleteById(id));
    }
}
