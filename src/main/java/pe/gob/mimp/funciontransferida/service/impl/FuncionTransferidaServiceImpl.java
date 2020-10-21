/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.funciontransferida.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.siscap.model.FuncionTransferida;
import pe.gob.mimp.siscap.repository.funciontransferida.FuncionTransRepository;
import pe.gob.mimp.funciontransferida.bean.FindByParamBean;
import pe.gob.mimp.funciontransferida.bean.FuncionTransferidaBean;
import pe.gob.mimp.funciontransferida.converter.FuncionTransferidaCast;
import pe.gob.mimp.funciontransferida.converter.TipoFuncionCast;
import pe.gob.mimp.funciontransferida.util.Util;
import pe.gob.mimp.funciontransferida.service.FuncionTransferidaService;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class FuncionTransferidaServiceImpl implements FuncionTransferidaService {

    @Autowired
    private FuncionTransRepository funcionTransferidaRepository;

    @Override
    public void crearFuncionTransferida(FuncionTransferidaBean funcionTransferidaBean) throws Exception {

        FuncionTransferida funcionTransferida = FuncionTransferidaCast.castFuncionTransferidaBeanToFuncionTransferida(funcionTransferidaBean);
        funcionTransferidaRepository.save(funcionTransferida);

    }

    @Override
    public void editarFuncionTransferida(FuncionTransferidaBean funcionTransferidaBean) {

        if (funcionTransferidaBean.getNidFuncionTransferida() == null) {
            return;
        }

        FuncionTransferida funcionTransferida = FuncionTransferidaCast.castFuncionTransferidaBeanToFuncionTransferida(funcionTransferidaBean);
        funcionTransferidaRepository.save(funcionTransferida);

    }

    @Override
    public String obtenerFuncionTransferidaPorId(BigDecimal nidFuncionTransferida) throws Exception {

        Optional<FuncionTransferida> funcionTransferida = funcionTransferidaRepository.findById(nidFuncionTransferida);

        if (funcionTransferida.isPresent()) {
            return funcionTransferida.get().getTxtFuncionTransferida();
        }

        return "";
    }

    @Override
    public List<FuncionTransferidaBean> loadFuncionTransferidaList(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }

        List<FuncionTransferida> funcionTransferidaList = funcionTransferidaRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (!Util.esListaVacia(funcionTransferidaList)) {

            return funcionTransferidaList.stream().map(funcionTransferida -> {
                return FuncionTransferidaCast.castFuncionTransferidaToFuncionTransferidaBean(funcionTransferida);
            }).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public Integer getRecordCount(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }
        Integer count = funcionTransferidaRepository.getRecordCount(findByParamBean.getParameters());
        return count;
    }

    @Override
    public FuncionTransferidaBean find(BigDecimal id) {

        Optional<FuncionTransferida> funcionTransferida = funcionTransferidaRepository.findById(id);

        if (!funcionTransferida.isPresent()) {
            return null;
        }

        return FuncionTransferidaCast.castFuncionTransferidaToFuncionTransferidaBean(funcionTransferida.get());

    }

}
