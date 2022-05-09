
import './App.css';
import axios from "axios";
import React from 'react';




export default class App extends React.Component { 
  state = {
    tareas: [],
    nombre: "",
    descripcion: ""

  }


  async componentDidMount() {
    var baseUrl = "http://localhost:8080/tarea/todos";
    var res = await axios.get(baseUrl);
    this.setState({ tareas: res.data });
    console.log(this.state.tareas);

  }

  onChangename2 = (e) => {
    this.setState({ descripcion: e.target.value });
  }

  onChangename = (o) => {
    this.setState({ nombre: o.target.value })
  }

  onSubmit = async (o, e) => {
    const res = await axios.post("http://localhost:8080/tarea", {
      nombre: this.state.nombre,
      descripcion: this.state.descripcion
    })
    this.setState({ nombre: "" })
    this.setState({ descripcion: "" })
    console.log(res)

  }

  deleteTarea = async (id) => {
    await axios.delete("http://localhost:8080/tarea/" + id)
    
  }

  putTarea = async (id) => {
    await axios.put("http://localhost:8080/tarea/" + id,{
      nombre: this.state.nombre,
      descripcion: this.state.descripcion
    }
     )
     this.setState({ nombre: "" })
     this.setState({ descripcion: "" })
    console.log(id);
  }

  

  render() {
    return (
      <div className="row">
        <div className="col-md-4">
          <div className="card card-body" >

            <h3>AGREGAR TAREA</h3>

            <form onSubmit={this.onSubmit}>
              <h3>Nombre de la tarea </h3>
              <div className="form-group">
                <input type="text" className="form-control" value={this.state.nombre} onChange={this.onChangename} />
              </div>

              <hr></hr>

              <h3>descripcion</h3>
              <div className="form-group">
                <input type="text" className="form-control" value={this.state.descripcion} onChange={this.onChangename2} />
              </div>

              <hr></hr>

              <button type="submit" className="btn btn-primary">
                Agregar
              </button>
            </form>
          </div>

        </div>

        <div className="col-md-8">
          <ul className="list-group">
            {
              this.state.tareas.map(tarea =>
                <><><li className="list-group-item list-group-item-action" key={tarea.id}>
                  <h1 className="title"> Nombre</h1>
                  {tarea.nombre}
                  <hr></hr>
                  <h1 className="title">Descripcion</h1>
                  {tarea.descripcion}
                  <hr></hr>
                  
                  <div className="row">          
                   <button type="submit" className="btn-primary" onClick={() => this.deleteTarea(tarea.id)}>
                    Eliminar
                   </button>
                   <hr></hr>

                   <button type="submit" className="btn-primary" onClick={() => this.putTarea(tarea.id)}>
                    Editar
                   </button>
                  </div>
                  <input type = "checkbox" className ="Check"></input>

                </li><hr></hr></><hr></hr></>

              )
            }
          </ul>
        </div>

      </div>

     


    );

  }

}


