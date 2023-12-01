package files;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
/** TODO: modify, change etc., this file to your needs
 @Retention and @Target inserted in the file there were missing */

public @interface MyAnnotation2 {

	String author();
	int majorVersion();
	int minorVersion();
}
