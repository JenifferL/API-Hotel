package br.edu.senai.sc.granHotel.service;

import br.edu.senai.sc.granHotel.Entity.Hospede;
import br.edu.senai.sc.granHotel.Repository.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospedeService {

    @Autowired
    private HospedeRepository hospedeRepository;

    public Hospede criarHospede(Hospede hospede) {
        return hospedeRepository.save(hospede);
    }

    public Hospede atualizarHospede(Long id, Hospede hospedeAtualizado) {
        Hospede hospede = hospedeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hóspede não encontrado"));

        hospede.setNome(hospedeAtualizado.getNome());
        hospede.setSobrenome(hospedeAtualizado.getSobrenome());
        hospede.setDataCheckIn(hospedeAtualizado.getDataCheckIn());
        hospede.setDataCheckOut(hospedeAtualizado.getDataCheckOut());

        return hospedeRepository.save(hospede);
    }

    public void excluirHospede(Long id) {
        hospedeRepository.deleteById(id);
    }

    public List<Hospede> listarHospedes() {
        return hospedeRepository.findAll();
    }

    public List<Hospede> buscarHospedesPorNome(String nome) {
        return hospedeRepository.findByNomeContaining(nome);
    }

    public Hospede buscarHospedePorId(Long id) {
        return hospedeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hóspede não encontrado"));
    }

}