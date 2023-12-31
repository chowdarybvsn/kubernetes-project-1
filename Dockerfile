FROM centos:7
MAINTAINER chowdarybvsn
RUN yum update -y
RUN yum install -y httpd \
 zip \
 unzip
ADD https://www.free-css.com/assets/files/free-css-templates/download/page292/simply-amazed.zip /var/www/html/
WORKDIR /var/www/html/
RUN unzip simply-amazed.zip
RUN cp -rvf 2123_simply_amazed/* .
RUN rm -rf 2123_simply_amazed simply-amazed.zip
CMD [ "/usr/sbin/httpd", "-D", "FOREGROUND" ]
EXPOSE 80 22