import React, {Component} from 'react';
import {connect} from "react-redux";

class Search extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <input className="fixed" type="text" placeholder="Input station name"
                       onChange={(e) => this.props.modifyData(e.target.value)}/>

                <table>
                    <tr>
                        <th>Id</th>
                        <th>Station</th>
                        <th>Place</th>
                        <th>Time</th>
                    </tr>
                    {(this.props.data).map(value => (
                        <tr key={value.id}>
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

const mapStateToProps = (state) => {
    return {data: state.data};
};

export default connect(mapStateToProps)(Search);