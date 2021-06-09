# EraTani

This repo is for Machine Learning path.

For our prediction we use public dataset from [BMKG](https://dataonline.bmkg.go.id/home). We collect the climate data for Surabaya from 01 January 2013 until 5 June 2021. From the dataset we train some features to predict forecast values for 28 days later. The features that we use is:
- **Tavg** : Average temperature
- **Tn** : Minimum temperature
- **Tx** : Maximum temperature
- **RH_avg** : Average humidity

We build the model and train the dataset using RNN Algorithm, implemeting with Tensorflow.