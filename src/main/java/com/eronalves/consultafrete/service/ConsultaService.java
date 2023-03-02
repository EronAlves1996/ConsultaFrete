package com.eronalves.consultafrete.service;

import com.eronalves.consultafrete.exception.ConsultaException;
import com.eronalves.consultafrete.models.dto.ConsultaDto;

public interface ConsultaService {

	ConsultaDto consultaFrete(ConsultaDto dto) throws ConsultaException;

}
