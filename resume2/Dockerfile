FROM sherlockke/our_ubuntu:latest
VOLUME /tmp
ADD target/resume2-0.0.1-SNAPSHOT.jar app.jar
ADD resume_server resume_server
#RUN apk add --update nodejs
#RUN apk add --update npm
#RUN npm install hackmyresume -g
#RUN npm cache clean -f 
#RUN npm install -g n
#RUN npm n stable
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar
