import React, {Component} from 'react';
import {connect} from 'react-redux';
import Search from "./Search";
import data from './api'

class App extends Component {
    constructor(props) {
        super(props);
    }

    modifyData = (value) => {
        this.props.dispatch({
            type: 'CHANGE_DATA', data: data.filter((element) => {
                return ((element.station).toLowerCase()).includes(value);
            })
        });
    };

    render() {
        return (
            <Search modifyData={this.modifyData}/>
        );
    }
}

const mapStateToProps = (state) => {
    return {data: state.data};
};

export default connect(mapStateToProps)(App);