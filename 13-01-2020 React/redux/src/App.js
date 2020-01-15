import React, {Component} from 'react';
import {connect} from 'react-redux';
import Search from "./Search";

class App extends Component {
    constructor(props) {
        super(props);
    }

    modifyData = (value) => {
        this.props.dispatch({
            type: 'CHANGE_DATA', value: value
        });
    };

    modifyChosen = (value) => {
        this.props.dispatch({
            type: 'CHANGE_CHOSEN', value: value
        });
    };

    render() {
        return (
            <Search modifyData={this.modifyData} modifyChosen={this.modifyChosen}/>
        );
    }
}

const mapStateToProps = (state) => {
    return {data: state.data, chosen: state.chosen};
};

export default connect(mapStateToProps)(App);