package cn.bx.annotation;


//@interface CusAnnotation{
//
//}
//
//@CusAnnotation
//public class CustomAnnotation {
//}


import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface Foo {}


@Foo
class SuperBar {

}

public class CustomAnnotation extends SuperBar {

}