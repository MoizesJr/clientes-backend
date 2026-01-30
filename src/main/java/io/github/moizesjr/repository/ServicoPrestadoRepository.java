package io.github.moizesjr.repository;

import io.github.moizesjr.model.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {

    /**
     * Realiza uma busca filtrada de serviços prestados por nome de cliente e mês.
     * * @param nome Nome do cliente (suporta busca parcial, ex: %NOME%).
     * @param mes Número do mês (1-12).
     * @return Lista de serviços que atendem aos critérios.
     */
    @Query(" select s from ServicoPrestado s join s.cliente c " +
            "where upper(c.nome) like upper(:nome) and MONTH (s.data) =:mes")
    List<ServicoPrestado> findByNomeClienteAndMes(
            @Param("nome") String nome, @Param("mes") Integer mes);
}
