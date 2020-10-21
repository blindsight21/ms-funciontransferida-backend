/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.funciontransferida.converter;

import java.math.BigInteger;
import pe.gob.mimp.funciontransferida.bean.FuncionTransferidaBean;
import pe.gob.mimp.siscap.model.FuncionTransferida;

/**
 *
 * @author Omar
 */
public class FuncionTransferidaCast {

    public static FuncionTransferidaBean castFuncionTransferidaToFuncionTransferidaBean(FuncionTransferida funcionTransferida) {

        if (funcionTransferida == null) {
            return null;
        }

        FuncionTransferidaBean funcionTransferidaBean = new FuncionTransferidaBean();

        funcionTransferidaBean.setNidFuncionTransferida(funcionTransferida.getNidFuncionTransferida());
        funcionTransferidaBean.setTxtFuncionTransferida(funcionTransferida.getTxtFuncionTransferida());
        funcionTransferidaBean.setTxtFuncionTranferidaDes(funcionTransferida.getTxtFuncionTranferidaDes());
        funcionTransferidaBean.setFlgActivo(funcionTransferida.getFlgActivo());
        funcionTransferidaBean.setNidUsuario(funcionTransferida.getNidUsuario());
        funcionTransferidaBean.setTxtPc(funcionTransferida.getTxtPc());
        funcionTransferidaBean.setTxtIp(funcionTransferida.getTxtIp());
        funcionTransferidaBean.setFecEdicion(funcionTransferida.getFecEdicion());
        funcionTransferidaBean.setTipoFuncionBean(TipoFuncionCast.castTipoFuncionToTipoFuncionBean(funcionTransferida.getNidTipoFuncion()));

        return funcionTransferidaBean;
    }
    
    public static FuncionTransferida castFuncionTransferidaBeanToFuncionTransferida(FuncionTransferidaBean funcionTransferidaBean) {

        if (funcionTransferidaBean == null) {
            return null;
        }

        FuncionTransferida funcionTransferida = new FuncionTransferida();

        funcionTransferida.setNidFuncionTransferida(funcionTransferidaBean.getNidFuncionTransferida());
        funcionTransferida.setTxtFuncionTransferida(funcionTransferidaBean.getTxtFuncionTransferida());
        funcionTransferida.setTxtFuncionTranferidaDes(funcionTransferidaBean.getTxtFuncionTranferidaDes());
        funcionTransferida.setFlgActivo(funcionTransferidaBean.getFlgActivo());
        funcionTransferida.setNidUsuario(funcionTransferidaBean.getNidUsuario());
        funcionTransferida.setTxtPc(funcionTransferidaBean.getTxtPc());
        funcionTransferida.setTxtIp(funcionTransferidaBean.getTxtIp());
        funcionTransferida.setFecEdicion(funcionTransferidaBean.getFecEdicion());
        funcionTransferida.setNidTipoFuncion(TipoFuncionCast.castTipoFuncionBeanToTipoFuncion(funcionTransferidaBean.getTipoFuncionBean()));

        return funcionTransferida;
    }
}
