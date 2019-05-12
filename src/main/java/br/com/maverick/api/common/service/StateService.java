package br.com.maverick.api.common.service;

import br.com.maverick.api.common.model.State;
import br.com.maverick.api.common.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public State getStateByNick(String nick) {
        List<State> states = stateRepository.findByNick(nick.toUpperCase());

        if (states.size() == 1) {
            return states.get(0);
        } else if (states.size() < 1) {
            throw new RuntimeException("Não foi encontrato nenhum estado com a sigla: '" + nick+ "'.");
        } else {
            throw new RuntimeException("Foram encontrados mais de um estado com a sigla: '" + nick + "'\n" +
                    "Entre em contrato com um administrador do sistema.");
        }
    }
}
