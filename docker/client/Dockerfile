FROM alpine/git
WORKDIR /app
RUN git clone https://github.com/djnoddyp/iron-tracker-rest.git

FROM node:6-alpine
WORKDIR /app
COPY --from=0 /app/iron-tracker-rest /app
RUN cd /iron-tracker-rest/client
RUN npm start