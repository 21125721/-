package org.stu.scoreinfo;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
/**
 * ����һ��ע��
 * @author 19392
 *
 */
@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface ColumnName {
	String value() default "";
}
