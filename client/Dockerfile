#FROM alpine/git
#WORKDIR /app
#RUN git clone https://github.com/djnoddyp/iron-tracker-rest.git

FROM node:6-alpine
WORKDIR /app
COPY ./ /app
RUN npm install
EXPOSE 3000
CMD ["npm","start"]
