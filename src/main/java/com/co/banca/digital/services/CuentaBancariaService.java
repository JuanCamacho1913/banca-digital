package com.co.banca.digital.services;

import com.co.banca.digital.dtos.*;
import com.co.banca.digital.exceptions.BalanceInsuficienteException;
import com.co.banca.digital.exceptions.ClienteNotFoundException;
import com.co.banca.digital.exceptions.CuentaBancariaNotFoundException;
import com.co.banca.digital.models.CuentaBancaria;

import java.util.List;

public interface CuentaBancariaService {

    ClienteDTO saveCliente(ClienteDTO clienteDTO);

    ClienteDTO getCliente(Long clienteId) throws ClienteNotFoundException;

    ClienteDTO updateCliente(ClienteDTO clienteDTO);

    List<ClienteDTO> searchClientes(String keyword);

    void deleteCliente(Long clienteId);

    CuentaActualDTO saveCuentaBancariaActual(double balanceInicial, double sobregiro, Long clienteId) throws ClienteNotFoundException;

    CuentaAhorroDTO saveCuentaBancariaAhorro(double balanceInicial, double tasaInteres, Long clienteId) throws ClienteNotFoundException;

    List<ClienteDTO> listClientes();

    CuentaBancariaDTO getCuentaBancaria(String cuentaId) throws CuentaBancariaNotFoundException;

    void debit(String cuentaId, double monto, String descripcion) throws CuentaBancariaNotFoundException, BalanceInsuficienteException;

    void credit(String cuentaId, double monto, String descripcion) throws CuentaBancariaNotFoundException;

    void transfer(String cuentaIdPropietario, String cuentaIdDestinatario, double monto) throws CuentaBancariaNotFoundException, BalanceInsuficienteException;

    List<CuentaBancariaDTO> listCuentasBancarias();

    List<OperacionCuentaDTO> listHistorialDeCuentas(String cuentaId);

    HistorialCuentaDTO getHistorialCuenta(String cuentaId, int  page, int size) throws CuentaBancariaNotFoundException;
}
