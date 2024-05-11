<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Criar Tarefas</title>
    <link rel="stylesheet" href="Style/CadTarefa.css">
</head>
<body>
    <div class="main-login">

        <div class="left-div">
            <h1>Crie sua Task</h1>
            <img alt="Apresentação" class="leftImage" src="Imagens/innovation-animate.svg">
        </div>
    
        <div class="right-login">
            <div class="card-login">
    
                <form action="/CreateTarefa" method="post">

                    <input id = "id" name = "id" type="text" hidden value="${param.id}">
                    <div class="textfield">
                        <label for="nomeTask">Nome da Tarefa</label>
                        <input id = "nomeTask" name = "nomeTask" type="text" value="${param.nomeTask}">
                    </div>
                    <div class="textfield">
                          
                    <label for="statusTask">Status da tarefa</label>
                    <select name="statusTask" id="statusTask" class="statusTask" value="${param.statusTask}">
                        <option value="completa" class="option">INICIALIZADA</option>
                        <option value="inicializada" class="option">ESTAMOS NA METADE</option>
                        <option value="terminada"class="option">FINALIZADA</option>
                    </select>
                    </div>
                    <button class="btn-login">Criar</button>
                </form>
            </div>
    
        </div>
    
    </div>
    
</body>
</html>