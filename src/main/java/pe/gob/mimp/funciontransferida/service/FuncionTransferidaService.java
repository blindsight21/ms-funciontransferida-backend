/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.funciontransferida.service;

import java.math.BigDecimal;
import java.util.List;
import pe.gob.mimp.funciontransferida.bean.FindByParamBean;
import pe.gob.mimp.funciontransferida.bean.FuncionTransferidaBean;

/**
 *
 * @author Omar
 */
public interface FuncionTransferidaService {

    void crearFuncionTransferida(FuncionTransferidaBean funcionTransferidaBean) throws Exception;

    void editarFuncionTransferida(FuncionTransferidaBean funcionTransferidaBean) throws Exception;

//    void anularFuncionTransferida(FuncionTransferidaBean funcionTransferidaBean) throws Exception;
    String obtenerFuncionTransferidaPorId(BigDecimal nidFuncionTransferida) throws Exception;

    List<FuncionTransferidaBean> loadFuncionTransferidaList(FindByParamBean findByParamBean) throws Exception;

    Integer getRecordCount(FindByParamBean findByParamBean) throws Exception;

    FuncionTransferidaBean find(BigDecimal id);

}
