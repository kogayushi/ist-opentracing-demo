# Distributed Tracing Demonstration
## preparation
run zipkin server
```bash
$ java -jar zipkin.jar
```

## display zipkin
go to http://localhost:9411/zipkin

## demonstration
### start small
```bash
for i in 1 2 ; do for j in brave sleuth ; do echo `curl -Ss 'http://localhost:808'$i'/to-'$j` ; done ; done
```

see zipkin server

### execute 400 request
```bash
for x in `seq 1 100 ` ; do for i in 1 2 ; do for j in brave sleuth ; do echo `curl -Ss 'http://localhost:808'$i'/to-'$j` ; done ; done ; done
```

see zipkin server
