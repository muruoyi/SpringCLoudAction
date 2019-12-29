FROM my-nginx:2.0

COPY default.conf /etc/nginx/conf.d/default.conf

RUN mkdir /root/www

COPY index.html /root/www

ENTRYPOINT ["nginx", "-g"," daemon off;"]
