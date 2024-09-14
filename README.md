### Alunos: César Eduardo de Souza e Lucas Ziemann
Objetivo: simulação da distribuição de carga de um pedágio para registro de pagamentos
Composição das mensagens que serão trocadas:

usage:
abra 3 terminais.
1º: make
    *obs. opção 1 deve ser criada passando um iD de cabine (o mesmo a ser passado como argumento para SysProvedor)
2º: java -cp out:/nishome/u08387785938/pedagio/Pedagio/amqp-client-5.16.0.jar:/nishome/u08387785938/pedagio/Pedagio/slf4j-api-1.7.36.jar:/nishome/u08387785938/pedagio/Pedagio/slf4j-simple-1.7.36.jar sistema.SysProvedor cabine0
3º: java -cp out:/nishome/u08387785938/pedagio/Pedagio/amqp-client-5.16.0.jar:/nishome/u08387785938/pedagio/Pedagio/slf4j-api-1.7.36.jar:/nishome/u08387785938/pedagio/Pedagio/slf4j-simple-1.7.36.jar sistema.Server
