package com.jardiano.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.jardiano.crud.exception.ResourceNotFoundException;
import com.jardiano.crud.model.Funcionario;
import com.jardiano.crud.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/*@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")*/
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping("/funcionario")
    public List<Funcionario> getAllEmployees() {
        return funcionarioRepository.findAll();
    }

    @GetMapping("/funcionario/{id}")
    public ResponseEntity<Funcionario> getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Funcionario funcionario = funcionarioRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionario não encontrado para este ID :: " + employeeId));
        return ResponseEntity.ok().body(funcionario);
    }

    @PostMapping("/funcionario")
    public Funcionario createEmployee(@Valid @RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @PutMapping("/funcionario/{id}")
    public ResponseEntity<Funcionario> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                      @Valid @RequestBody Funcionario funcionarioDetails) throws ResourceNotFoundException {
        Funcionario funcionario = funcionarioRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionario não encontrado para este ID :: " + employeeId));

        funcionario.setEmailId(funcionarioDetails.getEmailId());
        funcionario.setUltimoNome(funcionarioDetails.getUltimoNome());
        funcionario.setPrimeiroNome(funcionarioDetails.getPrimeiroNome());
        final Funcionario updatedFuncionario = funcionarioRepository.save(funcionario);
        return ResponseEntity.ok(updatedFuncionario);
    }

    @DeleteMapping("/funcionario/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Funcionario funcionario = funcionarioRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionario não encontrado para este ID :: " + employeeId));

        funcionarioRepository.delete(funcionario);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
