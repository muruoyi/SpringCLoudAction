FROM alpine:3.8

MAINTAINER dev-team

RUN echo http://mirrors.ustc.edu.cn/alpine/v3.8/main > /etc/apk/repositories && \
    echo http://mirrors.ustc.edu.cn/alpine/v3.8/community >> /etc/apk/repositories

RUN apk update
RUN apk add nginx
RUN apk add curl

RUN mkdir /run/nginx

CMD ["nginx", "-g"," daemon off;"]