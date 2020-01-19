package pt.ipleiria.estg.dei.aed.examenormal.modelo.comparadores;

import pt.ipleiria.estg.dei.aed.ComparacaoLimite;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;
import pt.ipleiria.estg.dei.aed.modelo.contactos.CoordenadaGeografica;

public enum ComparacaoContactosProximidadeGeografica implements ComparacaoLimite<Contacto> {
    CRITERIO;

    public static final CoordenadaGeografica COORDENADA_GEOGRAFICA_LEIRIA = new CoordenadaGeografica(39.735082, -8.820678);
    public static final CoordenadaGeografica COORDENADA_GEOGRAFICA_ANTIPODA_LEIRIA = new CoordenadaGeografica(-39.735082, 171.179322);

    private static final Contacto LIMITE = new Contacto("","",0,"",null,COORDENADA_GEOGRAFICA_ANTIPODA_LEIRIA);

    @Override
    public int comparar(Contacto o1, Contacto o2) {
        double d1 = o1.getCoordenadaGeografica().getDistancia(COORDENADA_GEOGRAFICA_LEIRIA);
        double d2 = o2.getCoordenadaGeografica().getDistancia(COORDENADA_GEOGRAFICA_LEIRIA);
        return Double.compare(d1,d2);
    }

    @Override
    public Contacto getLimite() {
        return LIMITE;
    }
}
