package com.fsdev.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsdev.os.domain.Cliente;
import com.fsdev.os.domain.OS;
import com.fsdev.os.domain.Tecnico;
import com.fsdev.os.domain.enums.Prioridade;
import com.fsdev.os.domain.enums.Status;
import com.fsdev.os.repositories.ClienteRepository;
import com.fsdev.os.repositories.OSRepository;
import com.fsdev.os.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private OSRepository osRepository;
	
	
	public void instaciaDB() {
		
		
		Tecnico t1 = new Tecnico(null, "Valdir Cesar", "289.044.120-21", "(99)99999-9999");
		Tecnico t2 = new Tecnico(null, "Linus Torvalds", "583.354.530-71", "(99)99999-7777");
		Cliente c1 = new Cliente(null, "Betina Campos", "445.093.480-61", "(99)99999-8888");
		OS os1 = new OS(null, Prioridade.ALTA, "Teste create OS", Status.ANDAMENTO, t1, c1);
		
		t1.getList().add(os1);
		c1.getList().add(os1);
		
		tecnicoRepository.saveAll(Arrays.asList(t1, t2));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
		
	}

}
