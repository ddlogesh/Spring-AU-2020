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

                <div>
                    <table>
                        <tr>
                            <th>Id</th>
                            <th>Station</th>
                            <th>Place</th>
                        </tr>
                        {(this.props.data) && (this.props.data).map(value => (
                            <tr key={value.id} onClick={() => this.props.modifyChosen(value)}>
                                <td>{value.id}</td>
                                <td>{value.station}</td>
                                <td>{value.city}, {value.state}, {value.country}</td>
                            </tr>
                        ))}
                    </table>
                </div>
                <div className="absolute top">
                    <table>
                        <tr>
                            <th>Id</th>
                            <th>Station</th>
                        </tr>
                        {(this.props.chosen) && (this.props.chosen).map(value => (
                            <tr key={value.id}>
                                <td>{value.id}</td>
                                <td>{value.station}</td>
                            </tr>
                        ))}
                    </table>
                </div>
            </div>
        );
    }
}

const mapStateToProps = (state) => {
    return {data: state.data, chosen: state.chosen};
};

export default connect(mapStateToProps)(Search);