package tg.univlome.cic.apoo.project.utils;

import java.util.Arrays;
import java.util.List;
import tg.univlome.cic.apoo.project.entities.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author djim
 */
class AnnotatedClassCollection {
    
    public static List<Class<?>> getAnnotatedClasses() {
        Class<?>[] classes = new Class<?>[]{
            Eleve.class, Classe.class, Cours.class,
            Enseignement.class, Enseignant.class,
            Evaluation.class,  Matiere.class, Periode.class,
            TypeEvaluation.class, HasParticipated.class,
            Niveau.class, Notes.class
        };

        return Arrays.asList(classes);
    }

    private AnnotatedClassCollection() {
        throw new AssertionError("No need to instanciate this class ...");
    }
}
