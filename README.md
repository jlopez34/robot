# Robot
Projeto da  NASA desenvolvido para explorar novas zonas em outro planeta usando robôs de varredura.
Foi decidido a criação um aplicativo usando tecnologias como SpringBoot2.0.6, Swagger, Junit sobre Java 8, essa implementação
deve fornecer as seguintes funcionalidades:
    
        - Mostrar a posição final quando o serviço foi consumido com sucesso.
        - Mostrar mensagem de status quando o serviço foi consumido com sucesso, mas a posição final está fora da área.
        - Mostrar mensagem de status quando o serviço foi consumido com sucesso, mas a instrução é um Comando Inválido.
 
# Problema :
Um time de robôs devem ser colocados pela NASA para explorar um terreno em Marte.
Esse terreno, que é retangular, precisa ser navegado pelos robôs de tal forma que suas
câmeras acopladas possam obter uma visão completa da região, enviando essas imagens
novamente para a Terra.
A posição de cada robô é representada pela combinação de coordenadas cartesianas (x, y)
e por uma letra, que pode representar uma das quatro orientações: NORTH, SOUTH, EAST
e WEST. Para simplificar a navegação, a região “marciana” a ser explorada foi subdividia
em sub-regiões retangulares.

# Requisitos do desafio:
        - O terreno deverá ser iniciado com 5x5 posições;
        - O robô inicia na coordenada (0,0,N);
        - Deverá ser possível enviar um comando para o Robô que me retorne a posição final dele;
        - O Robô não pode se movimentar para fora da área especificada;
        - Não deve guardar estado do robô para consulta posterior;

## Solução possível:

Foi desenvolvida a seguinte solução:
Implimentação Java API [mars.1.0.0.jar] usando Spring Boot 2.0.6, o serviço foi documentado e testado usando o framework
Swagger, é necessário seguir os próximos passos para colocar a solução em execução:

1. git clone https://github.com/jlopez34/robot

2. cd robot/mars/

3. mvn package

5. cd robot/mars/target/

6. java -jar mars.1.0.0.jar

7. http://localhost:8080/rest/mars/{instruction} no navegador que você preferir.

8. http://localhost:8080/swagger-ui.html/ api - teste de documentação e teste
