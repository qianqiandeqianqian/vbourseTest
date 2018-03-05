package com.hucheng.wallet.eth.contract;

import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.1.0.
 */
public class SntContract extends Contract {
    private static final String BINARY = "60606040526000600460146101000a81548160ff021916908315150217905550341561002a57600080fd5b5b5b33600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b5b5b611d8c8061007f6000396000f3006060604052361561011b576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806306fdde031461017c578063095ea7b31461020b5780630b7d63201461026557806318160ddd146102ba57806323b872dd146102e357806327e235e31461035c5780632a11ced0146103b4578063313ce5671461041757806334103ee41461044057806340c10f191461047957806341c0e1b5146104bb5780635f412d4f146104d057806370a08231146104e55780638da5cb5b1461053257806395d89b41146105875780639613252114610616578063a9059cbb14610643578063c44891101461069d578063dd62ed3e146106c6578063eb2f303814610732578063f2fde38b14610774575b5b60003411151561012b57600080fd5b3373ffffffffffffffffffffffffffffffffffffffff167fe1fffcc4923d04b559f4d29a8bfc6cda04eb5b0d3c460751c2402c5c5cc9109c346040518082815260200191505060405180910390a25b005b341561018757600080fd5b61018f6107ad565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156101d05780820151818401525b6020810190506101b4565b50505050905090810190601f1680156101fd5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561021657600080fd5b61024b600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919080359060200190919050506107e6565b604051808215151515815260200191505060405180910390f35b341561027057600080fd5b61027861096e565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34156102c557600080fd5b6102cd610994565b6040518082815260200191505060405180910390f35b34156102ee57600080fd5b610342600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803590602001909190505061099a565b604051808215151515815260200191505060405180910390f35b341561036757600080fd5b610393600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610de3565b60405180838152602001821515151581526020019250505060405180910390f35b34156103bf57600080fd5b6103d56004808035906020019091905050610e14565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b341561042257600080fd5b61042a610e54565b6040518082815260200191505060405180910390f35b341561044b57600080fd5b610477600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610e59565b005b341561048457600080fd5b6104b9600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091908035906020019091905050610f20565b005b34156104c657600080fd5b6104ce6111ac565b005b34156104db57600080fd5b6104e3611246565b005b34156104f057600080fd5b61051c600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506112c1565b6040518082815260200191505060405180910390f35b341561053d57600080fd5b61054561130e565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b341561059257600080fd5b61059a611334565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156105db5780820151818401525b6020810190506105bf565b50505050905090810190601f1680156106085780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561062157600080fd5b61062961136d565b604051808215151515815260200191505060405180910390f35b341561064e57600080fd5b610683600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091908035906020019091905050611380565b604051808215151515815260200191505060405180910390f35b34156106a857600080fd5b6106b06116bd565b6040518082815260200191505060405180910390f35b34156106d157600080fd5b61071c600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506116c6565b6040518082815260200191505060405180910390f35b341561073d57600080fd5b610772600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803590602001909190505061174e565b005b341561077f57600080fd5b6107ab600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050611b7b565b005b6040805190810160405280601381526020017f53696c656e74204e6f7461727920546f6b656e0000000000000000000000000081525081565b60008082148061087257506000600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054145b151561087d57600080fd5b81600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055508273ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925846040518082815260200191505060405180910390a3600190505b92915050565b600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60005481565b6000806040600481016000369050101515156109b557600080fd5b600460149054906101000a900460ff161515610a2857600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610a2757600080fd5b5b84600360008273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010160009054906101000a900460ff161515610ae45760028054806001018281610a939190611d0f565b916000526020600020900160005b83909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505b600560008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549250610baf600360008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000015486611c54565b600360008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000181905550610c41600360008973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000015486611c7f565b600360008973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600001819055506001600360008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010160006101000a81548160ff021916908315150217905550610cec8386611c7f565b600560008973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055508573ffffffffffffffffffffffffffffffffffffffff168773ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef876040518082815260200191505060405180910390a3600193505b5b505b5b50509392505050565b60036020528060005260406000206000915090508060000154908060010160009054906101000a900460ff16905082565b600281815481101515610e2357fe5b906000526020600020900160005b915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600481565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610eb557600080fd5b6000600460149054906101000a900460ff161515811515141515610ed857600080fd5b81600460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b5b505b50565b600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610f7c57600080fd5b600460149054906101000a900460ff16151515610f9857600080fd5b81600360008273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010160009054906101000a900460ff16151561105457600280548060010182816110039190611d0f565b916000526020600020900160005b83909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505b61106060005483611c54565b6000819055506110b2600360008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000015483611c54565b600360008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600001819055506001600360008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010160006101000a81548160ff0219169083151502179055508273ffffffffffffffffffffffffffffffffffffffff1660007fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef846040518082815260200191505060405180910390a35b5b505b5b5050565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561120857600080fd5b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16ff5b5b565b600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156112a257600080fd5b6001600460146101000a81548160ff0219169083151502179055505b5b565b6000600360008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000015490505b919050565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6040805190810160405280600481526020017f534e54520000000000000000000000000000000000000000000000000000000081525081565b600460149054906101000a900460ff1681565b600060406004810160003690501015151561139a57600080fd5b600460149054906101000a900460ff16151561140d57600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561140c57600080fd5b5b83600360008273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010160009054906101000a900460ff1615156114c957600280548060010182816114789190611d0f565b916000526020600020900160005b83909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505b611515600360003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000015485611c7f565b600360003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600001819055506115a7600360008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000015485611c54565b600360008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600001819055506001600360008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010160006101000a81548160ff0219169083151502179055508473ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef866040518082815260200191505060405180910390a3600192505b5b505b5b5092915050565b642e90edd00081565b6000600560008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205490505b92915050565b600080600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156117ad57600080fd5b33600360008273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010160009054906101000a900460ff16151561186957600280548060010182816118189190611d0f565b916000526020600020900160005b83909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505b3373ffffffffffffffffffffffffffffffffffffffff168573ffffffffffffffffffffffffffffffffffffffff16141515156118a457600080fd5b833073ffffffffffffffffffffffffffffffffffffffff1631101515156118ca57600080fd5b83642e90edd000111515156118de57600080fd5b6004600a0a92506118fd6118f28585611c99565b642e90edd000611ccd565b915061194b600360003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000015483611c54565b600360003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600001819055506119dd600360008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000015483611c7f565b600360008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600001819055506001600360003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010160006101000a81548160ff0219169083151502179055503373ffffffffffffffffffffffffffffffffffffffff168573ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef846040518082815260200191505060405180910390a38473ffffffffffffffffffffffffffffffffffffffff166108fc859081150290604051600060405180830381858888f193505050501515611b2357600080fd5b8473ffffffffffffffffffffffffffffffffffffffff167f357b676c439b9e49b4410f8eb8680bee4223724802d8e3fd422e1756f87b475f856040518082815260200191505060405180910390a25b5b505b50505050565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515611bd757600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16141515611c4f5780600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b5b5b50565b6000808284019050838110158015611c6c5750828110155b1515611c7457fe5b8091505b5092915050565b6000828211151515611c8d57fe5b81830390505b92915050565b60008082840290506000841480611cba5750828482811515611cb757fe5b04145b1515611cc257fe5b8091505b5092915050565b600080600083111515611cdc57fe5b8284811515611ce757fe5b0490508284811515611cf557fe5b068184020184141515611d0457fe5b8091505b5092915050565b815481835581811511611d3657818360005260206000209182019101611d359190611d3b565b5b505050565b611d5d91905b80821115611d59576000816000905550600101611d41565b5090565b905600a165627a7a723058203d23747db16a77ac103f05b4d00d0bbd1a9e1427691c85fee8eb93b7f862e3280029";

    protected SntContract(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SntContract(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<BurnedEventResponse> getBurnedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Burned", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<BurnedEventResponse> responses = new ArrayList<BurnedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            BurnedEventResponse typedResponse = new BurnedEventResponse();
            typedResponse.log = transactionReceipt.getLogs().get(valueList.indexOf(eventValues));
            typedResponse.burner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.holder = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.burnedAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<BurnedEventResponse> burnedEventObservable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        final Event event = new Event("Burned", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, BurnedEventResponse>() {
            @Override
            public BurnedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                BurnedEventResponse typedResponse = new BurnedEventResponse();
                typedResponse.log = log;
                typedResponse.burner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.holder = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.burnedAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<PayEventResponse> getPayEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Pay", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<PayEventResponse> responses = new ArrayList<PayEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            PayEventResponse typedResponse = new PayEventResponse();
            typedResponse.log = transactionReceipt.getLogs().get(valueList.indexOf(eventValues));
            typedResponse.to = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<PayEventResponse> payEventObservable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        final Event event = new Event("Pay", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, PayEventResponse>() {
            @Override
            public PayEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                PayEventResponse typedResponse = new PayEventResponse();
                typedResponse.log = log;
                typedResponse.to = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<DepositEventResponse> getDepositEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Deposit", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<DepositEventResponse> responses = new ArrayList<DepositEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            DepositEventResponse typedResponse = new DepositEventResponse();
            typedResponse.log = transactionReceipt.getLogs().get(valueList.indexOf(eventValues));
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<DepositEventResponse> depositEventObservable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        final Event event = new Event("Deposit", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, DepositEventResponse>() {
            @Override
            public DepositEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DepositEventResponse typedResponse = new DepositEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Transfer", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = transactionReceipt.getLogs().get(valueList.indexOf(eventValues));
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TransferEventResponse> transferEventObservable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        final Event event = new Event("Transfer", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Approval", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = transactionReceipt.getLogs().get(valueList.indexOf(eventValues));
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ApprovalEventResponse> approvalEventObservable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        final Event event = new Event("Approval", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<String> name() {
        Function function = new Function("name", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> approve(String _spender, BigInteger _value) {
        Function function = new Function(
                "approve", 
                Arrays.<Type>asList(new Address(_spender),
                new Uint256(_value)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> crowdsaleAgent() {
        Function function = new Function("crowdsaleAgent", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> totalSupply() {
        Function function = new Function("totalSupply", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> transferFrom(String _from, String _to,
            BigInteger _value) {
        Function function = new Function(
                "transferFrom", 
                Arrays.<Type>asList(new Address(_from),
                new Address(_to),
                new Uint256(_value)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple2<BigInteger, Boolean>> balances(String param0) {
        final Function function = new Function("balances", 
                Arrays.<Type>asList(new Address(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}));
        return new RemoteCall<Tuple2<BigInteger, Boolean>>(
                new Callable<Tuple2<BigInteger, Boolean>>() {
                    @Override
                    public Tuple2<BigInteger, Boolean> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);;
                        return new Tuple2<BigInteger, Boolean>(
                                (BigInteger) results.get(0).getValue(), 
                                (Boolean) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<String> holders(BigInteger param0) {
        Function function = new Function("holders", 
                Arrays.<Type>asList(new Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> decimals() {
        Function function = new Function("decimals", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setCrowdsaleAgent(String _crowdsaleAgent) {
        Function function = new Function(
                "setCrowdsaleAgent", 
                Arrays.<Type>asList(new Address(_crowdsaleAgent)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> mint(String receiver, BigInteger amount) {
        Function function = new Function(
                "mint", 
                Arrays.<Type>asList(new Address(receiver),
                new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> kill() {
        Function function = new Function(
                "kill", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> releaseTokenTransfer() {
        Function function = new Function(
                "releaseTokenTransfer", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> balanceOf(String _owner) {
        Function function = new Function("balanceOf", 
                Arrays.<Type>asList(new Address(_owner)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> owner() {
        Function function = new Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> symbol() {
        Function function = new Function("symbol", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Boolean> released() {
        Function function = new Function("released", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> transfer(String _to, BigInteger _value) {
        Function function = new Function(
                "transfer", 
                Arrays.<Type>asList(new Address(_to),
                new Uint256(_value)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> BUYOUT_PRICE() {
        Function function = new Function("BUYOUT_PRICE", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> allowance(String _owner, String _spender) {
        Function function = new Function("allowance", 
                Arrays.<Type>asList(new Address(_owner),
                new Address(_spender)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> buyout(String _holder, BigInteger _amount) {
        Function function = new Function(
                "buyout", 
                Arrays.<Type>asList(new Address(_holder),
                new Uint256(_amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String newOwner) {
        Function function = new Function(
                "transferOwnership", 
                Arrays.<Type>asList(new Address(newOwner)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<SntContract> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SntContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<SntContract> deploy(Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SntContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static SntContract load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new SntContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static SntContract load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SntContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class BurnedEventResponse {
        public Log log;

        public String burner;

        public String holder;

        public BigInteger burnedAmount;
    }

    public static class PayEventResponse {
        public Log log;

        public String to;

        public BigInteger value;
    }

    public static class DepositEventResponse {
        public Log log;

        public String from;

        public BigInteger value;
    }

    public static class TransferEventResponse {
        public Log log;

        public String from;

        public String to;

        public BigInteger value;
    }

    public static class ApprovalEventResponse {
        public Log log;

        public String owner;

        public String spender;

        public BigInteger value;
    }
}
