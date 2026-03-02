package estga.lp.trabalho1.randomgroupgeneratorlibrary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class GeradorDeGrupos {

    //guarda todos os estudantes disponiveis para criar grupos
    private final Collection<Estudante> estudantes = new ArrayList<>();
    //gerador de números aleatórios usado para selecionar estudantes
    private final Random random = new Random();

    public GeradorDeGrupos(Collection<Estudante> estudantes) {
        if (estudantes == null || estudantes.size() < 2) {
            throw new IllegalArgumentException("Número insuficiente de estudantes.");
        }
        this.estudantes.addAll(estudantes);
    }

    public Collection<Grupo> gerarGrupos() {

        //copiar estudantes para poder baralhar sem alterar a lista original
        ArrayList<Estudante> lista = new ArrayList<>();

        //baralhar aleatoriamente
        java.util.Collections.shuffle(lista, random);

        Collection<Grupo> grupos = new ArrayList<>();

        //criar grupos de 2 em 2
        for (int i = 0; i < lista.size() - 1; i++) {
            Estudante e1 = lista.get(i);
            Estudante e2 = lista.get(i + 1);

            grupos.add(new Grupo(e1, e2));
        }

        return grupos;

    }

}


