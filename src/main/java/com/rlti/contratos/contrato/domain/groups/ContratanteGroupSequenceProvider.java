package com.rlti.contratos.contrato.domain.groups;

import com.rlti.contratos.contratante.domain.Contratante;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class ContratanteGroupSequenceProvider implements DefaultGroupSequenceProvider<Contratante> {
    @Override
    public List<Class<?>> getValidationGroups(Contratante entity)  {
        List<Class<?>> groups = new ArrayList<>();

        /*
         * Informamos ao HibernateValidator para usar as validações default
         * definidas na classe Cliente.
         */
        groups.add(Contratante.class);

        if (entity != null) {
            /*
             * Aqui nós implementamos a lógica que determina o grupo de
             * validação a ser aplicado ao bean.
             */
            if ("FISICA".equalsIgnoreCase(String.valueOf(entity.getTipoPessoa()))) {
                groups.add(PessoaFisica.class);
            } else if ("JURIDICA".equalsIgnoreCase(String.valueOf(entity.getTipoPessoa()))) {
                groups.add(PessoaJuridica.class);
            }
        }
        return groups;
    }
}
