var container = document.getElementById("app")
// var titulo = document.createElement("h1")
// titulo.innerHTML = "Título inserido por JavaScript :0"
// container.appendChild(titulo)

function Contador(props) {

    // let n = 0;
    const [n, setN] = React.useState(0);
 
    function somar(){
        setN(n + 1);
        console.log("Somei e ficou = " + n)
    }

    function subtrair(){
        setN(n - 1);
        console.log("subtrair e ficou = " + n)
    }

    return (
        <React.Fragment>
            <h1>{props.titulo}</h1>
            <h2>{n}</h2>
            <button onClick = {somar}>+</button>
            <button onClick = {subtrair}>-</button>
        </React.Fragment>
    );
}

function App() {
    return (
        <React.Fragment>
            <h1>Vote no seu favorito</h1>
            <Contador titulo="Obelisco, o Atormentador" />
            <Contador titulo="Slifer, o Dragão Celeste" />
            <Contador titulo="O Dragão Alado de Rá" />
        </React.Fragment>
    );
}

ReactDOM.render(React.createElement(App, null, null), container);

// PascalCase -> Componente em React seguem esse padrão
// camelCase -> Funções em JavaScript
// Componentes só podem retornar em elemento por Componente
// saída => aninhar em React.Fragment