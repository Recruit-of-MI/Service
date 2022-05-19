FROM java:8
VOLUME /tmp
ADD *.jar nethome.jar
EXPOSE 19080
ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/nethome.jar" ]
ENV JAVA_HOME=/jdk8
ENV PATH=$JAVA_HOME/bin:$PATH
ENV CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar