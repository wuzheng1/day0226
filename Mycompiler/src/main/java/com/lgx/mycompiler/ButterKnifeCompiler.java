package com.lgx.mycompiler;

import com.google.auto.service.AutoService;
import com.lgx.myanno.BindView;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;
import javax.tools.JavaFileObject;

@AutoService(Processor.class)
public class ButterKnifeCompiler extends AbstractProcessor {

    private Filer filer;

    @Override
    public SourceVersion getSupportedSourceVersion() {
        SourceVersion.latestSupported();
        return super.getSupportedSourceVersion();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        LinkedHashSet<Object> objects = new LinkedHashSet<>();
        objects.add(BindView.class.getCanonicalName())
        return super.getSupportedAnnotationTypes();
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        filer = processingEnvironment.getFiler();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Set<? extends Element> elementsAnnotatedWith = roundEnvironment.getElementsAnnotatedWith(BindView.class);

        HashMap<String, List<VariableElement>> stringListHashMap = new HashMap<>();

        for (Element el:elementsAnnotatedWith) {
            VariableElement variableElement= (VariableElement) el;
            String s = variableElement.getEnclosingElement().getSimpleName().toString();
            List<VariableElement> elementList = stringListHashMap.get(s);
            if (elementList == null){
                elementList = new ArrayList<>();
                stringListHashMap.put(s,elementList);
            }
            elementList.add(variableElement);

        }
        return false;
    }
}
