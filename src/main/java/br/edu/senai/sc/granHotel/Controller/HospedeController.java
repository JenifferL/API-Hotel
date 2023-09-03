package br.edu.senai.sc.granHotel.Controller;

import br.edu.senai.sc.granHotel.Entity.Hospede;
import br.edu.senai.sc.granHotel.Repository.HospedeRepository;
import br.edu.senai.sc.granHotel.service.HospedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospedes")
public class HospedeController {

    @GetMapping("/cad")
    public ResponseEntity<Hospede> helloWorld(){
        Hospede hospede = new Hospede();
        hospede.setId(hospede.getId());
        hospede.setNome("Daniel");
        hospede.setSobrenome("Claudino");
        //hospede.setDataCheckIn();
        //hospede.setDataCheckOut();

        return new ResponseEntity<>(hospede, HttpStatus.OK);
    }
    @Autowired
    private HospedeService hospedeService;

    @PostMapping
    public Hospede criarHospede(@RequestBody Hospede hospede) {
        return hospedeService.criarHospede(hospede);
    }

    @PutMapping("/alterar/{id}")
    public Hospede atualizarHospede(@PathVariable Long id, @RequestBody Hospede hospedeAtualizado) {
        return hospedeService.atualizarHospede(id, hospedeAtualizado);
    }

    @DeleteMapping("/{id}")
    public void excluirHospede(@PathVariable Long id) {
        hospedeService.excluirHospede(id);
    }

    @GetMapping
    public List<Hospede> listarHospedes() {
        return hospedeService.listarHospedes();
    }

    @GetMapping("/filtro")
    public List<Hospede> buscarHospedesPorNome(@RequestParam String nome) {
        return hospedeService.buscarHospedesPorNome(nome);
    }

    @GetMapping("/{id}")
    public Hospede buscarHospedePorId(@PathVariable Long id) {
        return hospedeService.buscarHospedePorId(id);
    }

}
