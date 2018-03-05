package com.hucheng.wallet.eth.contract;

import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.1.0.
 */
public class KinContract extends Contract {
    private static final String BINARY = "60606040526006805460ff191660011790555b60018054600160a060020a03191633600160a060020a03161790555b5b610bd88061003e6000396000f300606060405236156100ee5763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166306fdde0381146100f35780630952c5041461017e578063095ea7b31461019f57806318160ddd146101d557806323b872dd146101fa5780632a8092df14610236578063313ce5671461025d57806340c10f191461028657806370a08231146102aa57806379ba5097146102db5780638da5cb5b146102f057806395d89b411461031f578063a9059cbb146103aa578063d091b550146103e0578063dc39d06d1461040f578063dd62ed3e14610445578063ef70aebf1461047c575b600080fd5b34156100fe57600080fd5b610106610491565b60405160208082528190810183818151815260200191508051906020019080838360005b838110156101435780820151818401525b60200161012a565b50505050905090810190601f1680156101705780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561018957600080fd5b61019d600160a060020a03600435166104c8565b005b34156101aa57600080fd5b6101c1600160a060020a036004351660243561055d565b604051901515815260200160405180910390f35b34156101e057600080fd5b6101e8610584565b60405190815260200160405180910390f35b341561020557600080fd5b6101c1600160a060020a036004358116906024351660443561058a565b604051901515815260200160405180910390f35b341561024157600080fd5b6101c16105b3565b604051901515815260200160405180910390f35b341561026857600080fd5b6102706105bc565b60405160ff909116815260200160405180910390f35b341561029157600080fd5b61019d600160a060020a03600435166024356105c1565b005b34156102b557600080fd5b6101e8600160a060020a0360043516610685565b60405190815260200160405180910390f35b34156102e657600080fd5b61019d6106a4565b005b34156102fb57600080fd5b610303610733565b604051600160a060020a03909116815260200160405180910390f35b341561032a57600080fd5b610106610742565b60405160208082528190810183818151815260200191508051906020019080838360005b838110156101435780820151818401525b60200161012a565b50505050905090810190601f1680156101705780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34156103b557600080fd5b6101c1600160a060020a0360043516602435610779565b604051901515815260200160405180910390f35b34156103eb57600080fd5b6103036107a0565b604051600160a060020a03909116815260200160405180910390f35b341561041a57600080fd5b6101c1600160a060020a03600435166024356107af565b604051901515815260200160405180910390f35b341561045057600080fd5b6101e8600160a060020a036004358116906024351661086d565b60405190815260200160405180910390f35b341561048757600080fd5b61019d61089a565b005b60408051908101604052600381527f4b696e0000000000000000000000000000000000000000000000000000000000602082015281565b60015433600160a060020a039081169116146104e357600080fd5b600160a060020a03811615156104f857600080fd5b6002805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0383811691909117918290559081169033167f13a4b3bc0d5234dd3d87c9f1557d8faefa37986da62c36ba49309e2fb2c9aec460405160405180910390a35b5b50565b60065460009060ff161561057057600080fd5b61057a8383610900565b90505b5b92915050565b60035481565b60065460009060ff161561059d57600080fd5b6105a88484846109a9565b90505b5b9392505050565b60065460ff1681565b601281565b60015433600160a060020a039081169116146105dc57600080fd5b60065460ff1615156105ed57600080fd5b600354610600908263ffffffff610abb16565b600355600160a060020a03821660009081526005602052604090205461062c908263ffffffff610abb16565b600160a060020a0383166000818152600560205260408082209390935590917fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9084905190815260200160405180910390a35b5b5b5050565b600160a060020a0381166000908152600560205260409020545b919050565b60025460009033600160a060020a039081169116146106c257600080fd5b50600180546002805473ffffffffffffffffffffffffffffffffffffffff19808416600160a060020a03838116919091179586905591169091559081169116817f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a35b5b50565b600154600160a060020a031681565b60408051908101604052600381527f4b494e0000000000000000000000000000000000000000000000000000000000602082015281565b60065460009060ff161561078c57600080fd5b61057a8383610ad5565b90505b5b92915050565b600254600160a060020a031681565b60015460009033600160a060020a039081169116146107cd57600080fd5b600154600160a060020a038085169163a9059cbb9116846000604051602001526040517c010000000000000000000000000000000000000000000000000000000063ffffffff8516028152600160a060020a0390921660048301526024820152604401602060405180830381600087803b151561084957600080fd5b6102c65a03f1151561085a57600080fd5b50505060405180519150505b5b92915050565b600160a060020a038083166000908152600460209081526040808320938516835292905220545b92915050565b60015433600160a060020a039081169116146108b557600080fd5b60065460ff1615156108c6576108fd565b6006805460ff191690557ff48339e4a272bd7aee715c343ca34ad137607f1df78cf8d7ba137228954d2d8560405160405180910390a15b5b565b600081158015906109355750600160a060020a0333811660009081526004602090815260408083209387168352929052205415155b1561093f57600080fd5b600160a060020a03338116600081815260046020908152604080832094881680845294909152908190208590557f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b9259085905190815260200160405180910390a35060015b92915050565b600160a060020a0380841660008181526004602090815260408083203390951683529381528382205492825260059052918220546109ed908463ffffffff610b9516565b600160a060020a038087166000908152600560205260408082209390935590861681522054610a22908463ffffffff610abb16565b600160a060020a038516600090815260056020526040902055610a4b818463ffffffff610b9516565b600160a060020a03808716600081815260046020908152604080832033861684529091529081902093909355908616917fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9086905190815260200160405180910390a3600191505b509392505050565b600082820183811015610aca57fe5b8091505b5092915050565b600160a060020a033316600090815260056020526040812054610afe908363ffffffff610b9516565b600160a060020a033381166000908152600560205260408082209390935590851681522054610b33908363ffffffff610abb16565b600160a060020a0380851660008181526005602052604090819020939093559133909116907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9085905190815260200160405180910390a35060015b92915050565b600082821115610ba157fe5b508082035b929150505600a165627a7a723058203b88537fce9422de85446a6e402b3642009e6557f14364ffb0a9244cd94406340029";

    protected KinContract(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected KinContract(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<MintingEndedEventResponse> getMintingEndedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("MintingEnded", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<MintingEndedEventResponse> responses = new ArrayList<MintingEndedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            MintingEndedEventResponse typedResponse = new MintingEndedEventResponse();
            typedResponse.log = transactionReceipt.getLogs().get(valueList.indexOf(eventValues));
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MintingEndedEventResponse> mintingEndedEventObservable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        final Event event = new Event("MintingEnded", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, MintingEndedEventResponse>() {
            @Override
            public MintingEndedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                MintingEndedEventResponse typedResponse = new MintingEndedEventResponse();
                typedResponse.log = log;
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

    public List<OwnershipRequestedEventResponse> getOwnershipRequestedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("OwnershipRequested", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<OwnershipRequestedEventResponse> responses = new ArrayList<OwnershipRequestedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            OwnershipRequestedEventResponse typedResponse = new OwnershipRequestedEventResponse();
            typedResponse.log = transactionReceipt.getLogs().get(valueList.indexOf(eventValues));
            typedResponse._by = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OwnershipRequestedEventResponse> ownershipRequestedEventObservable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        final Event event = new Event("OwnershipRequested", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, OwnershipRequestedEventResponse>() {
            @Override
            public OwnershipRequestedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                OwnershipRequestedEventResponse typedResponse = new OwnershipRequestedEventResponse();
                typedResponse.log = log;
                typedResponse._by = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("OwnershipTransferred", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = transactionReceipt.getLogs().get(valueList.indexOf(eventValues));
            typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OwnershipTransferredEventResponse> ownershipTransferredEventObservable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        final Event event = new Event("OwnershipTransferred", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
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

    public RemoteCall<TransactionReceipt> requestOwnershipTransfer(String _newOwnerCandidate) {
        Function function = new Function(
                "requestOwnershipTransfer", 
                Arrays.<Type>asList(new Address(_newOwnerCandidate)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> approve(String _spender, BigInteger _value) {
        Function function = new Function(
                "approve", 
                Arrays.<Type>asList(new Address(_spender),
                new Uint256(_value)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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

    public RemoteCall<Boolean> isMinting() {
        Function function = new Function("isMinting", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<BigInteger> decimals() {
        Function function = new Function("decimals", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> mint(String _to, BigInteger _amount) {
        Function function = new Function(
                "mint", 
                Arrays.<Type>asList(new Address(_to),
                new Uint256(_amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> balanceOf(String _owner) {
        Function function = new Function("balanceOf", 
                Arrays.<Type>asList(new Address(_owner)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> acceptOwnership() {
        Function function = new Function(
                "acceptOwnership", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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

    public RemoteCall<TransactionReceipt> transfer(String _to, BigInteger _value) {
        Function function = new Function(
                "transfer", 
                Arrays.<Type>asList(new Address(_to),
                new Uint256(_value)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> newOwnerCandidate() {
        Function function = new Function("newOwnerCandidate", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> transferAnyERC20Token(String _tokenAddress,
            BigInteger _amount) {
        Function function = new Function(
                "transferAnyERC20Token", 
                Arrays.<Type>asList(new Address(_tokenAddress),
                new Uint256(_amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> allowance(String _owner, String _spender) {
        Function function = new Function("allowance", 
                Arrays.<Type>asList(new Address(_owner),
                new Address(_spender)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> endMinting() {
        Function function = new Function(
                "endMinting", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<KinContract> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(KinContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<KinContract> deploy(Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(KinContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static KinContract load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new KinContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static KinContract load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new KinContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class MintingEndedEventResponse {
        public Log log;
    }

    public static class ApprovalEventResponse {
        public Log log;

        public String owner;

        public String spender;

        public BigInteger value;
    }

    public static class TransferEventResponse {
        public Log log;

        public String from;

        public String to;

        public BigInteger value;
    }

    public static class OwnershipRequestedEventResponse {
        public Log log;

        public String _by;

        public String _to;
    }

    public static class OwnershipTransferredEventResponse {
        public Log log;

        public String _from;

        public String _to;
    }
}
