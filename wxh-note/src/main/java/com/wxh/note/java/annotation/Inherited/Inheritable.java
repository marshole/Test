package com.wxh.note.java.annotation.Inherited;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Inheritable {
    /**当注解Inheritable被@Inherited标注时，它具有继承性。否则，没有继承性。*/
}


@Inheritable
class InheritableFather{
    public InheritableFather() {
        // InheritableBase是否具有 Inheritable Annotation
        System.out.println("InheritableFather : " + InheritableFather.class.isAnnotationPresent(Inheritable.class));
    }
}

class InheritableSon extends InheritableFather {

    public InheritableSon() {
        super();
        // InheritableSon类是否具有 Inheritable Annotation
        System.out.println("InheritableSon:" + InheritableSon.class.isAnnotationPresent(Inheritable.class));
    }

    public static void main(String[] args) {
        InheritableSon is = new InheritableSon();
    }
}
