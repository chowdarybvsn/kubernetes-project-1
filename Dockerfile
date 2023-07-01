FROM centos:latest
MAINTAINER chowdarybvsn
RUN yum install -y httpd \
    zip \
    unzip
ADD https://www.free-css.com/assets/files/free-css-templates/download/page292/simply-amazed.zip /var/www/html/
WORKDIR /var/www/html/
RUN unzip simply-amazed.zip
RUN cp -rvf simply-amazed/* .
RUN rm -rf simply-amazed simply-amazed.zip
CMD [ "/usr/sbin/httpd", "-D", "FOREGROUND" ]
EXPOSE 80 22