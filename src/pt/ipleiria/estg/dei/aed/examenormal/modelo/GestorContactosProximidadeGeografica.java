package pt.ipleiria.estg.dei.aed.examenormal.modelo;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.ComparacaoInteiros;
import pt.ipleiria.estg.dei.aed.ComparacaoLimite;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaCircularBaseNaoOrdenada;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaSimplesCircularBaseNaoOrdenada;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaSimplesCircularBaseLimiteOrdenada;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaSimplesCircularBaseOrdenada;
import pt.ipleiria.estg.dei.aed.colecoes.naoiteraveis.ColecaoNaoIteravel;
import pt.ipleiria.estg.dei.aed.examenormal.modelo.comparadores.ComparacaoContactosProximidadeGeografica;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;
import pt.ipleiria.estg.dei.aed.modelo.contactos.CoordenadaGeografica;
import pt.ipleiria.estg.dei.aed.modelo.pessoas.Pessoa;
import pt.ipleiria.estg.dei.aed.modelo.pessoas.comparadores.ComparacaoPessoasPorBIAscendente;

import java.util.LinkedList;
import java.util.List;

public enum GestorContactosProximidadeGeografica {
    INSTANCIA;

    public static final CoordenadaGeografica COORDENADA_GEOGRAFICA_LEIRIA = new CoordenadaGeografica(39.735082, -8.820678);
    public static final CoordenadaGeografica COORDENADA_GEOGRAFICA_ANTIPODA_LEIRIA = new CoordenadaGeografica(-39.735082, 171.179322);

    public ListaSimplesCircularBaseLimiteOrdenada<Contacto> contactos;

    GestorContactosProximidadeGeografica() {
        contactos = new ListaSimplesCircularBaseLimiteOrdenada<>(ComparacaoContactosProximidadeGeografica.CRITERIO);
    }

    public void inserir(Contacto contacto) {
        contactos.inserir(contacto);
    }

    public IteradorIteravel<Contacto> getContactos() {
        return contactos.iterador();
    }

    public IteradorIteravel<Contacto> consultar(double distancia) {
        ListaSimplesCircularBaseLimiteOrdenada<Contacto> aux = new ListaSimplesCircularBaseLimiteOrdenada<>(ComparacaoContactosProximidadeGeografica.CRITERIO);

        for (Contacto contacto: contactos) {
            if (contacto.getCoordenadaGeografica().getDistancia(COORDENADA_GEOGRAFICA_LEIRIA) < distancia)
                aux.inserir(contacto);
        }

        return aux.iterador();
    }

    public IteradorIteravel<Contacto> consultar(double distancia, int anoNascimento) {
        ListaSimplesCircularBaseLimiteOrdenada<Contacto> aux = new ListaSimplesCircularBaseLimiteOrdenada<>(ComparacaoContactosProximidadeGeografica.CRITERIO);

        for (Contacto contacto: contactos) {
            if (contacto.getCoordenadaGeografica().getDistancia(COORDENADA_GEOGRAFICA_LEIRIA) < distancia &&
                contacto.getDataNascimento().getAno() == anoNascimento)
                    aux.inserir(contacto);
        }

        return aux.iterador();
    }

}
