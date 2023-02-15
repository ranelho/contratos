package com.rlti.contratos.contrato.domain.groups;

import com.rlti.contratos.contrato.domain.Contratada;
import lombok.extern.log4j.Log4j2;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;
@Log4j2
public class ContratadaGroupSequenceProvider implements DefaultGroupSequenceProvider<Contratada> {

    @Override
    public List<Class<?>> getValidationGroups(Contratada entity) {
        List<Class<?>> groups = new ArrayList<>();

        /*
         * Informamos ao HibernateValidator para usar as validações default
         * definidas na classe Cliente.
         */
        groups.add(Contratada.class);

        if (entity != null) {
            /*
             * Aqui nós implementamos a lógica que determina o grupo de
             * validação a ser aplicado ao bean.
             */
            if ("FISICA".equalsIgnoreCase(String.valueOf(entity.getTipoPessoa()))) {
                groups.add(CpfGroup.class);
            } else if ("JURIDICA".equalsIgnoreCase(String.valueOf(entity.getTipoPessoa()))) {
                groups.add(CnpjGroup.class);
            }
        }
        return groups;
    }
}
