package com.cadastro.adapter;

import java.util.ArrayList;
import java.util.List;

import com.cadastro.dto.PessoaDTO;
import com.cadastro.entity.Pessoa;

public class PessoaAdapter {
	
	public static PessoaDTO toDTO(Pessoa pessoa) {
		PessoaDTO pessoaDTO = new PessoaDTO();
		pessoaDTO.setId(pessoa.getId().intValue());
		pessoaDTO.setNome(pessoa.getNome());
		pessoaDTO.setDataNascimento(pessoa.getDataNascimento());
		return pessoaDTO;
	}
	
	public static List<PessoaDTO> toDTOList(List<Pessoa> pessoas) {
		
		List<PessoaDTO> listaPessoaDTO = new ArrayList<PessoaDTO>();
		
		for (Pessoa pessoa : pessoas) {
			PessoaDTO pessoaDTO = new PessoaDTO();
			pessoaDTO.setId(pessoa.getId().intValue());
			pessoaDTO.setNome(pessoa.getNome());
			pessoaDTO.setDataNascimento(pessoa.getDataNascimento());
			listaPessoaDTO.add(pessoaDTO);
		}
		
		return listaPessoaDTO;
	}

}
