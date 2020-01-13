import React, {Component} from 'react';
import data from './api'

class App extends Component {
    constructor(props) {
        super(props);

        this.state = {
            chosen: "",
            data: data
        }
    }

    modifyData(value) {
        this.setState({
            data: data.filter((element) => {
                return element.station.includes(value);
            })
        });
    }

    showData(value) {
        this.setState({chosen: value});
    }

    render() {
        return (
            <div>
                <p className="fixed top">{this.state.chosen.station}</p>
                <input className="fixed" type="text" onChange={(e) => this.modifyData(e.target.value)}/>
                <table>
                    <tr>
                        <th>Id</th>
                        <th>Station</th>
                        <th>Place</th>
                        <th>Time</th>
                    </tr>
                    {this.state.data.map((value, index) => (
                        <tr key={value.id} onClick={() => this.showData(value)}>
                            <td>{value.id}</td>
                            <td>{value.station}</td>
                            <td>{value.city}, {value.state}, {value.country}</td>
                            <td>{value.last_update}</td>
                        </tr>
                    ))}
                </table>
            </div>
        );
    }
}

export default App;