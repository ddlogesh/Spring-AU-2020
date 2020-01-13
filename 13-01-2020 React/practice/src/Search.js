import React, {Component} from 'react';

class Search extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <input className="fixed" type="text" onChange={(e) => this.props.modifyData(e.target.value)}/>

                <table>
                    <tr>
                        <th>Id</th>
                        <th>Station</th>
                        <th>Place</th>
                        <th>Time</th>
                    </tr>
                    {this.props.data.map((value, index) => (
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

export default Search;