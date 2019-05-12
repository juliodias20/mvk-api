package br.com.maverick.api.common.controller;

import br.com.maverick.api.common.model.State;
import br.com.maverick.api.common.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateController {

    @Autowired
    private StateService stateService;

    @ResponseBody
    @GetMapping("/states/{nick}")
    public State getStateByNick(@PathVariable String nick){
        return this.stateService.getStateByNick(nick);
    }
}
