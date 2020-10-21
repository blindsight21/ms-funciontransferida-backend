/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.funciontransferida.ws.rest;

import java.math.BigDecimal;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.mimp.funciontransferida.bean.FindByParamBean;

import pe.gob.mimp.funciontransferida.bean.ResponseData;
import pe.gob.mimp.funciontransferida.bean.FuncionTransferidaBean;
import pe.gob.mimp.funciontransferida.service.FuncionTransferidaService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/")
public class FuncionTransferidaController {

    @Autowired
    private FuncionTransferidaService funcionTransferidaService;

    @PostMapping(value = "/crearFuncionTransferida", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearFuncionTransferida(@RequestBody FuncionTransferidaBean funcionTransferidaBean) throws Exception {

        funcionTransferidaService.crearFuncionTransferida(funcionTransferidaBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/editarFuncionTransferida", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> editarFuncionTransferida(@RequestBody FuncionTransferidaBean funcionTransferidaBean) throws Exception {

        funcionTransferidaService.editarFuncionTransferida(funcionTransferidaBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/obtenerFuncionTransferidaPorId/{nidFuncionTransferida}")
    public ResponseEntity<ResponseData<?>> obtenerFuncionTransferidaPorId(@PathVariable("nidFuncionTransferida") BigDecimal nidFuncionTransferida) throws Exception {

        String txtFuncionTransferida = funcionTransferidaService.obtenerFuncionTransferidaPorId(nidFuncionTransferida);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(txtFuncionTransferida);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/loadFuncionTransferidaList", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> loadFuncionTransferidaList(@RequestBody FindByParamBean findByParamBean) throws Exception {

        List<FuncionTransferidaBean> funcionTransferidaList = funcionTransferidaService.loadFuncionTransferidaList(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(funcionTransferidaList);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/getRecordCount", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> getRecordCount(@RequestBody FindByParamBean findByParamBean) throws Exception {

        Integer count = funcionTransferidaService.getRecordCount(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(count);

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ResponseData<?>> find(@PathVariable("id") BigDecimal id) throws Exception {

        FuncionTransferidaBean funcionTransferidaBean = funcionTransferidaService.find(id);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(funcionTransferidaBean);

        return ResponseEntity.ok(response);

    }

}
