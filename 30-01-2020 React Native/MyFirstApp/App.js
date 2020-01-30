import React, {Component} from 'react';
import {View, StyleSheet, Text} from 'react-native';

class App extends Component {
    render() {
        return (
            <View>
                <Text style={styles.titleText}>
                    Hello Logesh!
                </Text>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    titleText: {
        fontSize: 20,
        fontWeight: 'bold',
    },
});

export default App;
